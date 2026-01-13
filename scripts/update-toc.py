#!/usr/bin/env python3
from __future__ import annotations

import re
from pathlib import Path


TOC_START = "<!-- TOC START -->"
TOC_END = "<!-- TOC END -->"


def slugify(text: str) -> str:
    lowered = text.strip().lower()
    # Remove punctuation except spaces and hyphens.
    cleaned = re.sub(r"[^a-z0-9\s-]", "", lowered)
    collapsed = re.sub(r"[\s-]+", "-", cleaned).strip("-")
    return collapsed


def collect_headings(lines: list[str]) -> list[tuple[int, str]]:
    headings: list[tuple[int, str]] = []
    in_code_block = False
    for line in lines:
        if line.startswith("```"):
            in_code_block = not in_code_block
            continue
        if in_code_block:
            continue
        match = re.match(r"^(#{2,4})\s+(.+)$", line)
        if not match:
            continue
        level = len(match.group(1))
        title = match.group(2).strip()
        headings.append((level, title))
    return headings


def build_toc(headings: list[tuple[int, str]]) -> list[str]:
    toc_lines: list[str] = []
    seen: dict[str, int] = {}
    for level, title in headings:
        if title == "Table of Contents":
            continue
        indent = "  " * (level - 2)
        base = slugify(title)
        count = seen.get(base, 0)
        anchor = base if count == 0 else f"{base}-{count}"
        seen[base] = count + 1
        toc_lines.append(f"{indent}- [{title}](#{anchor})")
    return toc_lines


def update_readme(readme_path: Path) -> bool:
    content = readme_path.read_text(encoding="utf-8")
    lines = content.splitlines()

    if TOC_START not in lines or TOC_END not in lines:
        raise SystemExit(
            f"Missing TOC markers in {readme_path}. "
            f"Add {TOC_START} and {TOC_END}."
        )

    start_index = lines.index(TOC_START)
    end_index = lines.index(TOC_END)
    if end_index <= start_index:
        raise SystemExit("TOC markers are out of order.")

    headings = collect_headings(lines)
    toc_lines = build_toc(headings)

    updated_lines = (
        lines[: start_index + 1] + toc_lines + lines[end_index:]
    )
    updated_content = "\n".join(updated_lines) + "\n"

    if updated_content != content:
        readme_path.write_text(updated_content, encoding="utf-8")
        return True
    return False


def main() -> int:
    repo_root = Path(__file__).resolve().parents[1]
    index_path = repo_root / "Index.md"
    if not index_path.exists():
        index_path = repo_root / "index.md"
    if not index_path.exists():
        raise SystemExit("Missing index.md or Index.md at repo root.")
    changed = update_readme(index_path)
    return 0 if not changed else 0


if __name__ == "__main__":
    raise SystemExit(main())

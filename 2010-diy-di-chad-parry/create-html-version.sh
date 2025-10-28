#!/usr/bin/env bash
#vi: ft=bash

usage(){
    echo USAGE: $0 \"My Title\" my-file.md
    exit 1
}

if [[ $# != 2 ]]; then 
    usage
fi

title="$1"
doc="$2"

if ! [[ -e "$doc" ]]; then
    echo "\"$doc\" is not a file"
    usage
fi

if ! echo -n "$doc" | egrep '.md$' > /dev/null; then
    echo "\"$doc\" needs to end in '.md'"
    usage
fi

outfile="$(basename "$doc" .md).html"

cat << EOF > "$outfile"
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8" >
        <title>$title</title>
    </head>

    <body>
EOF

markdown_py -x fenced_code "$doc" >> "$outfile"

cat << EOF >> "$outfile"

</body>
</html>
EOF

echo "File converted!"
echo "Now, go to https://www.freeconvert.com/html-to-epub to create an epub version" 

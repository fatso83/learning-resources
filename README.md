# Learning Resources

These are some of the resources that I find stands the test of time,
typically deeply influencing me at some point and/or standing as great 
reference pieces that are worth revisiting in a world filled with constant flux.

After 15 years, I have seen how many of my favorite articles and resources 
have started vanishing, and so I thought I would save the ones I could, trying to
attribute the original owner as best I could.

I will try to add some context for each entry.

## Dependency Injection and writing testable code
I got my first professional job in software in late 2010 and quickly got interested in
unit testing and related topics such as dependency injection (DI). 
I found the annotations and "magic" used everywhere hindered my understanding 
of what was really going on. 

### DIY DI by Chad Parry
One influental guy at Google that wrote a ton of articles about the topic 
at the time (2008-2010) was Miško Hevery of Google ([Google Guice][guice], Angular, Qwik, ...).

[guice]: https://github.com/google/guice/wiki/

In his [blog](https://web.archive.org/web/20121003131612/http://misko.hevery.com/2010/05/26/do-it-yourself-dependency-injection/) he recommended a set of documents by Chad Parry on "DIY DI". This was finally the simple, down-to-earth explanation I had been looking for! And it really resonated with me, showing how easy DI really is under the hood.

It does away with all the magic in favor of moving all construction the static `main` method and a bunch of providers and factories (glue code), ensuring no business code is constructing its own dependencies.

Chad's [original blog entry](https://blacksheep.parry.org/archives/diy-di) is still online, with all files, but in case it goes down I made a copy of the [original pdf](./assets/2010-chad-parry-DIY-DI.pdf).
For easy viewing I manually created a [Markdown version](./2010-diy-di-chad-parry/DIY_DI.md) of the pdf and unzipped
the [code examples](./2010-diy-di-chad-parry/java).

#### Related:
- the old internal [Google Guide on Writing Testable Code](https://github.com/mhevery/guide-to-testable-code?) is quite succinct.

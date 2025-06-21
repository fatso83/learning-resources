# Learning Resources

These are some of the resources that I find stands the test of time,
typically deeply influencing me at some point and/or standing as great 
reference pieces that are worth revisiting in a world filled with constant flux.

After 15 years, I have seen how many of my favorite articles and resources 
have started vanishing, and so I thought I would save the ones I could, trying to
attribute the original owner as best I could.

I will try to add some context for each entry.

## Dependency Injection and writing testable code

I got my first professional job in software in 2010 and quickly got interested in
unit testing and related topics such as dependency injection (DI), themes never
covered in school. Unfortunately, I found the XML, annotations and "magic" used everywhere 
hindered my understanding of what was really going on. 

One influental guy at Google that wrote a ton of articles about good testing practices
at the time (2008-2010) was Miško Hevery of Google. He later took those approaches into practice
by creating ([Google Guice][guice], the original AngularJS, Qwik and more. 

[guice]: https://github.com/google/guice/wiki/

### The Google Guide on Writing Testable Code
Miško Hevery's [Google Guide on Writing Testable Code](https://github.com/mhevery/guide-to-testable-code) 
summarises much of the blog articles. It is relatively short and succinct.

#### Related

##### Google Testing Blog: SMURF - Beyond the test pyramid

> While useful, the test pyramid lacks the details you need as your test suite grows and you face challenging trade-offs. To scale your test suite, go beyond the test pyramid. The SMURF mnemonic is an easy way to remember the tradeoffs to consider when balancing your test suite

Speed (faster = bette), Maintanability (too much code gets expensive, trim, balance), Utilization (use fewer resources), Reliability (fail for important reasons), Fidelity (High-fidelity tests come closer to approximating real operating conditions (e.g., real databases or traffic loads) and better predict the behavior of our production systems)

[smurf-link]: https://testing.googleblog.com/2024/10/smurf-beyond-test-pyramid.html
[smurf-pdf]: ./.assets/Google Testing Blog_ SMURF_ Beyond the Test Pyramid.pdf

[Original][smurf-link] and [pdf][smurf-pdf]

### DIY DI by Chad Parry

In Miško's [blog](https://web.archive.org/web/20121003131612/http://misko.hevery.com/2010/05/26/do-it-yourself-dependency-injection/) I came across a recommendation to read Chad Parry's take on "DIY DI". This was finally the simple, down-to-earth explanation I had been looking for! And it really resonated with me, showing how easy DI really is under the hood.

It does away with all the magic, in favor of moving all construction to the static `main` method and a bunch of providers and factories (glue code), ensuring no business code is constructing its own dependencies. I still think this is how one should approach learning what DI is and I still think (as of 2025) that this is sufficient for a lot of projects.

I extracted the source code and made a Markdown version you can see [here](./2010-diy-di-chad-parry).

### Testing Through the Domain: the example (Anders Sveen)
A [full repository on Github](https://github.com/anderssv/the-example/) with working code and Markdown documents explaining the intent and workings of how to do effective testing through the domain using Fakes. Really cleared up some misconceptions for me and made it much easier to adopt and understand.
Also goes for full manual DI, but instead of the factories of the DIY DI approach he has choses to use a DI Container that holds all the dependencies.

#### Related

##### Asgaut Mjølnes' ["Use of Fakes for domain driven design and fast feedback loop"](https://asgaut.com/use-of-fakes-for-domain-driven-design-and-fast-feedback-loop/). 
Great article on how Asgaut and Anders worked on improving the state of Sparebank 1 testing.

##### [Google Testing Blog: Increase Test Fidelity By Avoiding Mocks][test-fidelity-link] ([pdf][test-fidelity-pdf])

> The fidelity of a test refers to how closely the behavior of the test resembles the behavior of the production code. A test with higher fidelity gives you higher confidence that your code will work properly.

Use real code if possible - but weigh against potential downsides, fall back to fakes otherwise, and if there really is no other way: resort to mocking.

[test-fidelity-link]: https://testing.googleblog.com/2024/02/increase-test-fidelity-by-avoiding-mocks.html
[test-fidelity-pdf]: ./.assets/Google Testing Blog_ Increase Test Fidelity By Avoiding Mocks.pdf


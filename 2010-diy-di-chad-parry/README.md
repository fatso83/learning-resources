# About this version of DIY-DI

This small article is a reference piece in the 2010's, as it proved how easy it is to do manual DI without being confused by the "magic" of the fancy IOC frameworks, so I thought it should make it more easily accessible. It bothered me that it was just available as a PDF render, so this repo fixes that (I have gotten Chad's approval, btw!).

Chad's [original blog entry](https://blacksheep.parry.org/archives/diy-di) is still online, with all files, but in case it goes down I saved a copy of the [original pdf](../.assets/2010-chad-parry-DIY-DI.pdf). 

## Improvements on the original
For easier viewing, the possibility of creating HTML and epub versions, I 
- created a [Markdown version](./DIY_DI.md) of the pdf and an associated `./create-html-version.sh` script
- created an [EPUB](../.assets/DIY_DI.epub) of the HTML from that Markdown
- extracted the code examples and added a Maven build to be able to smoothly check out the source files in your IDE

## Source tree

The source code is about 1000 LOC of Java:
```
src/
├── external
│   └── java
│       └── dipresentation
│           ├── Account.java
│           ├── ApplicationWrapper.java
│           ├── MarketService.java
│           ├── Provider.java
│           ├── Providers.java
│           └── ScopeCache.java
└── main
    └── java
        └── dipresentation
            ├── step1_naive
            │   ├── MarketClient.java
            │   ├── Trade.java
            │   └── TradingApplication.java
            ├── step2_valueobjects
            │   ├── BookingService.java
            │   ├── MarketClient.java
            │   ├── Trade.java
            │   └── TradingApplication.java
            ├── step3_constructorinjection
            │   ├── BookingService.java
            │   ├── MarketClient.java
            │   ├── Trade.java
            │   └── TradingApplication.java
            ├── step4_trivialconstructors
            │   ├── BookingService.java
            │   ├── MarketClient.java
            │   ├── Trade.java
            │   └── TradingApplication.java
            ├── step5_thinharness
            │   ├── BookingService.java
            │   ├── MarketClient.java
            │   ├── Trade.java
            │   ├── TradingApplication.java
            │   └── TradingArgs.java
            ├── step6_injector
            │   ├── BookingService.java
            │   ├── MarketClient.java
            │   ├── Trade.java
            │   ├── TradingApplication.java
            │   ├── TradingArgs.java
            │   └── TradingInjector.java
            ├── step7_demeter
            │   ├── BookingService.java
            │   ├── MarketClient.java
            │   ├── SettlementCalculator.java
            │   ├── Trade.java
            │   ├── TradingApplication.java
            │   ├── TradingArgs.java
            │   └── TradingInjector.java
            ├── step8_providers
            │   ├── BookingService.java
            │   ├── MarketClient.java
            │   ├── SettlementCalculator.java
            │   ├── Trade.java
            │   ├── TradingApplication.java
            │   ├── TradingArgs.java
            │   └── TradingInjector.java
            └── step9_scopes
                ├── ApplicationScope.java
                ├── BookingService.java
                ├── MarketClient.java
                ├── SettlementCalculator.java
                ├── Trade.java
                ├── TradingApplication.java
                ├── TradingArgs.java
                └── TradingInjector.java

16 directories, 54 files

github.com/AlDanial/cloc v 2.06  T=0.03 s (1550.5 files/s, 43012.6 lines/s)
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Java                            54            414              0           1084
```

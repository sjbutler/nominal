# nominal

nominal is a Java library designed to test compliance of
identifier names with naming conventions.

nominal provides a configuration language to represent
identifier naming conventions that can be used to specify
conventions to test against. A description of the language
can be found in the docs directory.

## Copyright and License

nominal is Copyright (C) 2013-2015 The Open University and
Copyright (C) 2017 Simon Butler. nominal is open
source software licensed under version 2.0 of the Apache License. 
A copy of the licence can be found in the file LICENCE and the
text is available at https://www.apache.org/licenses/LICENSE-2.0

## Requirements

nominal requires Java v8 to run. 

## Build
nominal is built using Gradle.

## Dependencies

nominal has the following dependencies:
 1. SLF4J - nominal uses SLF4J for logging. Incorporating SLF4J in
    (existing) code is straightforward. A copy of slf4j-api.x.x.x.jar
    must be on the classpath when compiling and running nominal.
    Another slf4j jar will also be required to support logging
    -- see http://slf4j.org/ for more information
    nominal was coded against slf4j v1.7.7, so v1.7.7 or greater
    should work
 2. mdsc - nominal uses mdsc which is available at
    https://github.com/sjbutler/mdsc/
 3. idtk - nominal uses classes from idtk which is available at
    https://github.com/sjbutler/idtk-j/
 4. ANTLR - ANTLR 4 is required to run nominal and to compile any
    changes to the grammar. antlr-x.x-complete.jar must be on
    the classpath. nominal was coded against ANTLR v4.4
    See http://www.antlr.org/
    (ANTLRWorks 2 is a useful tool for working with ANTLR grammars)


## Caveat

nominal is research software. As such it is subject to change and
no guarantees can be made about the stability of any API. There is
also no guarantee that nominal will be maintained.

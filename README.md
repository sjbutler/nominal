<!-- 
    SPDX-FileCopyrightText: 2013-2015 The Open University
    SPDX-FileCopyrightText: 2017-2021 Simon Butler
    SPDX-License-Identifier: Apache-2.0
-->
# nominal

nominal is a Java library designed to test compliance of identifier
names with naming conventions.

nominal provides a configuration language to represent identifier
naming conventions that can be used to specify conventions to test
against. A description of the language can be found in the docs
directory.

## Copyright and License

nominal is Copyright (C) 2013-2015 The Open University and Copyright
(C) 2017-2019 Simon Butler. nominal is open source software licensed
under version 2.0 of the Apache License.  A copy of the licence can be
found in the directory LICENCES and the text is available at
https://www.apache.org/licenses/LICENSE-2.0

## Getting Started
A guide to working with nominal can be found at https://github.com/sjbutler/nominal/wiki/Nominal:-Getting-Started

## Requirements

nominal requires Java v8 to run. 

## Build
nominal is built using maven, and could be built using Gradle or Ivy.

## Dependencies

nominal has the following dependencies:
 1. SLF4J - nominal uses SLF4J for logging. Incorporating SLF4J in
    (existing) code is straightforward. A copy of slf4j-api.x.x.x.jar
    must be on the classpath when compiling and running nominal.
    Another slf4j jar will also be required to support logging
    -- see http://slf4j.org/ for more information
    nominal was coded against slf4j v1.7.25, so v1.7.25 or greater
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
 5. Apache Commons Lang3 - is available from https://commons.apache.org/

All dependencies are available from maven central and specified in the POM.

## Citation
Nominal was developed during the PhD research of Simon Butler. If
using nominal or extending nominal, or referring to it you should cite
the following paper:

``` bibtex
@InProceedings{Butler:2015:b,
 author={Butler, Simon and Wermelinger, Michel and Yu, Yijun},
  booktitle={2015 IEEE International Conference on Software Maintenance and Evolution (ICSME)}, 
  title={Investigating Naming Convention Adherence in {J}ava References}, 
  year={2015},
  pages={41-50},
  doi={10.1109/ICSM.2015.7332450}
}
```
The full text of the paper is available from [IEEEXplore](https://doi.org/10.1109/ICSM.2015.7332450) (access may be restricted), or [http://oro.open.ac.uk/43372](http://oro.open.ac.uk/43372)

## Caveat

nominal is research software. As such it is subject to change and no
guarantees can be made about the stability of any API. There is also
no guarantee that nominal will be maintained.



<!-- 
    SPDX-FileCopyrightText: 2017 Simon Butler
    SPDX-License-Identifier: Apache-2.0
-->
# Nominal: Language v1

Nominal provides a simple language to specify identifier naming
conventions. The language was conceived with the conventions published
in the 'Java Language Specification' and 'The Elements of Java Style'
in mind. Accordingly, the the language specifies conventions on a
program-wide basis for identifier name 'species' (class, method,
field, etc.). Additionally a number of subspecies, e.g. boolean local
variable, are also defined.


## Syntax & File Organisation

nominal draws on the syntax of cascading style sheets (CSS) to specify
naming conventions for identifier species and subspecies
(e.g. field-constant). The species/subspecies are Java specific (up to
Java v7) and are arranged in hierarchies.  For example,
`local-variable` has a child `local-variable-boolean`. See below for
more detail.

A second part of the file allows the declaration of lists of values
for ciphers (single letter abbreviations), branding etc. The lists can
be global, in which case they are declared with the keyword `default`
(see below for details).

A third part of the file contains a block of global settings marked
`global`. This is a place for features that don't have a home yet, and
is the least stable part of the file organisation.

## Default Values and Inheritance

Without the use of inheritance and default values, declaring
conventions in nominal would become unnecessarily repetitive and
verbose. A consequence would be that important details become
difficult to see.

The species and subspecies are organised in trees with the root of
each tree a species. Sometimes a species is the only member of a
tree. The names used for the species and subspecies reflect the
hierarchy so `field-constant` is the child of `field` and
`field-constant-boolean` is the child of
`field-constant`. Consequently, field might define a rule for
typography that is inherited by `field-constant` and
`field-constant-boolean`, unless the typography is redefined further
down the tree.

Default rules are:
 * separator characters (none)
 * the use of plurals (unspecified)
 * redundant prefixes (none)

The first two can be overridden in any rule, the last cannot, but this
is expected to change in a future version.


## Declaring Lists

nominal supports the declaration of lists of ciphers, and will support
lists of prefixes and brands.

### Cipher Lists

Cipher lists provide a means of declaring names and types that can be
used in local variable and formal argument names, by default, and
field names if desired. As many cipher lists can be declared as
required. However, only one may be declared using the `default`
keyword. The default cipher list is referenced using `cipher` in a
relevant species/subspecies rule. A named list is referenced using
`ciphers <list-name>`.

A default cipher list can be declared as follows:
```
  cipher-list default {
    b : boolean, Boolean, byte,Byte;
    c : char, Character;
    d : double, Double;
    e : *Exception;
    f : float, Float;
    i,j,k : int, Integer;
    l : long, Long;
    o : Object;
    s : String;
    v : *;
  }
```

The character to the left of the colon in each declaration is a
cipher. There may be a list of ciphers before the colon, but the
cipher should only appear once in the list. A list of types follows
the colon. The `*` is a wildcard. `*Exception` means any type name
ending with `Exception` and `*` means any type name. The identifier
`default` means that this list is used any time the keyword `cipher`
is found in a `content` field. Alternative lists of ciphers may be
declared with alternative identifiers e.g. `cipher-list foo {
... }`. The alternative list would then be used in a content
declaration with the keyword `ciphers` and the list identifier,
e.g. `content: ciphers foo, ...;`.

### Prefix Lists

Prefix lists are intended to provide lists of approved prefixes for
reference names. For example, variable field names might have the
prefix `m_`. This functionality is not yet fully implemented.

### Branding Lists

Brands are prefixes used to identify classes and methods in
particular. For example, Jasper Reports uses `JR` to brand
interfaces. This functionality is not yet fully implemented.

## Species and Subspecies

Nominal allows the following species and subspecies to be used to
specify rules.

- `class`
  - `class-gui-action`
  - `class-static-services`

- `interface`
  - `interface-mix-in`

- `annotation`

- `enumeration`

- `method`
  - `method-boolean-args`
  - `method-boolean-noargs`
  - `method-nonboolean-args`
  - `method-nonboolean-noargs`
  - `method-void-args`
  - `method-void-noargs`

- `annotation-member`

- `enumeration-constant`

- `field`
  - `field-constant`
    - `field-constant-boolean`
    - `field-constant-other`
    - `field-constant-string`
    - `field-constant-collection-reference`
  - `field-variable`
    - `field-variable-action`
    - `field-variable-boolean`
    - `field-variable-collection-reference`
    - `field-variable-other`

- `formal-argument`
  - `formal-argument-action`
  - `formal-argument-boolean`
  - `formal-argument-collection-reference`
  - `formal-argument-other`

- `local-variable`
  - `local-variable-action`
  - `local-variable-boolean`
  - `local-variable-collection-reference`
  - `local-variable-loop-control`
  - `local-variable-other`

- `label`


## Typography

Typography is defined using four instructions. The following rule for a local variable states that the first character of the name should be lower case, and that the body of the name should follow the mixed case (camel case) convention. The capitalisation of acronyms in mixed case names can also be specified. Currently this is done in the `global` section of the file.
```
local-variable {
    first-char: lower;
    body: mixed;
}
```

The following rule for a constant field name also includes the use of separator characters. Currently the `separator` keyword allows a set of separator characters to be specified separated by commas. The default behaviour is that only one separator character is permitted between each token in a name, but `+` can be appended to any separator character to permit the use of one or more consecutive separators, e.g. `separator: _+,$;` which allows multiple underscores between tokens and single dollar signs.
```
field-constant {
    first-char: upper;
    body: upper;
    separator: _;
}
```

## Content Types

Content types permitted in a name are defined using the `content` keyword. For example:
```
content: cipher, type-acronym, NP;
```

The language allows the specification of phrasal and non-phrasal
content.

Phrasal content is specified using the Penn Treebank chunk tags `NP`,
`VP`, `PP`, `AdjP` and `AdvP`. The chunk tags may be used individually
or in combination to define more complex phrases. The keyword
`complex` can also be used as a wildcard for combinations of two or
more chunk tags.

Non-phrasal content may be specified using the keywords `cipher`, `type-acronym` and `abbreviation`.

`cipher` is defined above. _Type acronyms_ are acronyms derived from
type names, e.g `InputStream is` and `StringBuilder sb`. Nominal
derives type acronyms when checking names. However our research found
an additional type of type acronym where the type acronym is derived
from the super class, for example `BufferedOutputStream os`. Nominal
does not detect this kind of type acronym nor can it be specified in a
rule. The necessary functionality is planned for a future
version. Abbreviations are defined in dictionaries in mdsc.

## Limitations and Future Directions

This version of nominal is relatively unsophisticated providing
project wide convention rules using a restricted set of species and
subspecies.

The next versions of the nominal language are expected to include:
- finer-grained declarations, i.e. more subspecies, and the possibility of declaring conventions for packages, and particular categories of class
- mixtures of content types, i.e. the declaration of a name template containing multiple content types
- more content types

Another avenue of development to be explored is the creation of a
meta-language for nominal that would allow the specification of
selector names, definitions, and hierarchies of selectors. A
meta-lanugage would allow the nominal language to specify conventions
for programming languages other than Java.

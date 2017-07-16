/*
    Copyright (C) 2013-2015 The Open University

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
/**
 * Nominal provides an API to to check Java identifier names for compliance  
 * with naming conventions. 
 * 
 * <p>Use the {@linkplain Nominal} class to load a set of conventions. Create 
 * instances of {@linkplain IdentifierName} to represent names to be tested
 * and test names using {@link Nominal#test(uk.ac.open.crc.nominal.IdentifierName) Nominal.test()}. 
 * The results of tests are are contained in {@code Information} instances that 
 * annotate {@code IdentifierName}</p>
 * 
 */

package uk.ac.open.crc.nominal;

/*
    Copyright (C) 2013-2015 The Open University
    Copyright (C) 2017 Simon Butler

    SPDX-FileCopyrightText: 2013-2015 The Open University
    SPDX-FileCopyrightText: 2017 Simon Butler
    SPDX-License-Identifier: Apache-2.0

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

package uk.ac.open.crc.nominal.util;

import java.util.HashSet;
import java.util.Set;

/**
 * A simple reference of collection class names.
 *
 */
public class CollectionReference {

    private static final Set<String> collectionClassNames;
    
    static {
        collectionClassNames = new HashSet<>();
        collectionClassNames.add("ArrayDeque");
        collectionClassNames.add("java.util.ArrayDeque");
        collectionClassNames.add("ArrayList");
        collectionClassNames.add("java.util.ArrayList");
        collectionClassNames.add("BitSet");
        collectionClassNames.add("java.util.BitSet");
        collectionClassNames.add("Collection");
        collectionClassNames.add("java.util.Collection");
        collectionClassNames.add("Deque");
        collectionClassNames.add("java.util.Deque");
//        collectionClassNames.add("Dictionary");
//        collectionClassNames.add("java.util.Dictionary");
//        collectionClassNames.add("EnumMap");
//        collectionClassNames.add("java.util.EnumMap");
        collectionClassNames.add("EnumSet");
        collectionClassNames.add("java.util.EnumSet");
//        collectionClassNames.add("HashMap");
//        collectionClassNames.add("java.util.HashMap");
        collectionClassNames.add("HashSet");
        collectionClassNames.add("java.util.HashSet");
        collectionClassNames.add("Hashtable");
        collectionClassNames.add("java.util.Hashtable");
//        collectionClassNames.add("IdentityHashMap");
//        collectionClassNames.add("java.util.IdentityHashMap");
//        collectionClassNames.add("LinkedHashMap");
//        collectionClassNames.add("java.util.LinkedHashMap");
        collectionClassNames.add("LinkedHashSet");
        collectionClassNames.add("java.util.LinkedHashSet");
        collectionClassNames.add("LinkedList");
        collectionClassNames.add("java.util.LinkedList");
        collectionClassNames.add("List");
        collectionClassNames.add("java.util.List");
//        collectionClassNames.add("Map");
//        collectionClassNames.add("java.util.Map");
//        collectionClassNames.add("NavigableMap");
//        collectionClassNames.add("java.util.NavigableMap");
        collectionClassNames.add("NavigableSet");
        collectionClassNames.add("java.util.NavigableSet");
        collectionClassNames.add("PriorityQueue");
        collectionClassNames.add("java.util.PriorityQueue");
        collectionClassNames.add("Queue");
        collectionClassNames.add("java.util.Queue");
        collectionClassNames.add("Set");
        collectionClassNames.add("java.util.Set");
//        collectionClassNames.add("SortedMap");
//        collectionClassNames.add("java.util.SortedMap");
        collectionClassNames.add("SortedSet");
        collectionClassNames.add("java.util.SortedSet");
        collectionClassNames.add("Stack");
        collectionClassNames.add("java.util.Stack");
//        collectionClassNames.add("TreeMap");
//        collectionClassNames.add("java.util.TreeMap");
        collectionClassNames.add("TreeSet");
        collectionClassNames.add("java.util.TreeSet");
        collectionClassNames.add("Vector");
        collectionClassNames.add("java.util.Vector");
//        collectionClassNames.add("WeakHashMap");
//        collectionClassNames.add("java.util.WeakHashMap");
        // concurrency package collections
        collectionClassNames.add("BlockingDeque");
        collectionClassNames.add("java.util.concurrent.BlockingDeque");
//        collectionClassNames.add("ConcurrentMap");
//        collectionClassNames.add("java.util.concurrent.ConcurrentMap");
//        collectionClassNames.add("ConcurrentNavigableMap");
//        collectionClassNames.add("java.util.concurrent.ConcurrentNavigableMap");
//        collectionClassNames.add("ConcurrentHashMap");
//        collectionClassNames.add("java.util.concurrent.ConcurrentHashMap");
        collectionClassNames.add("ConcurrentLinkedDeque");
        collectionClassNames.add("java.util.concurrent.ConcurrentLinkedDeque");
        collectionClassNames.add("ConcurrentLinkedQueue");
        collectionClassNames.add("java.util.concurrent.ConcurrentLinkedQueue");
//        collectionClassNames.add("ConcurrentSkipListMap");
//        collectionClassNames.add("java.util.concurrent.ConcurrentSkipListMap");
        collectionClassNames.add("ConcurrentSkipListSet");
        collectionClassNames.add("java.util.concurrent.ConcurrentSkipListSet");
        collectionClassNames.add("CopyOnWriteArrayList");
        collectionClassNames.add("java.util.concurrent.CopyOnWriteArrayList");
        collectionClassNames.add("CopyOnWriteArraySet");
        collectionClassNames.add("java.util.concurrent.CopyOnWriteArraySet");
        collectionClassNames.add("DelayedQueue");
        collectionClassNames.add("java.util.concurrent.DelayedQueue");
        collectionClassNames.add("LinkedBlockingDeque");
        collectionClassNames.add("java.util.concurrent.LinkedBlockingDeque");
        collectionClassNames.add("LinkedBlockingQueue");
        collectionClassNames.add("java.util.concurrent.LinkedBlockingQueue");
        collectionClassNames.add("LinkedTransferQueue");
        collectionClassNames.add("java.util.concurrent.LinkedTransferQueue");
        collectionClassNames.add("PriorityBlockingQueue");
        collectionClassNames.add("java.util.concurrent.PriorityBlockingQueue");
        collectionClassNames.add("SynchronousQueue");
        collectionClassNames.add("java.util.concurrent.SynchronousQueue");
    }
    
    public static boolean isCollection( String s ) {
        return collectionClassNames.contains( s );
    }
    
    private CollectionReference() {}
}

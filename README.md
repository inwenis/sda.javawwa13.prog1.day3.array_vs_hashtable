# Data structures - Array vs HashMap

The purpose of this repo is to show the importance of using correct data structures.


## Array

Use `PatientRegistryUsingArray` to see how long it takes to loop up 100 patients in a `Array`

A single client needs ~8s to lookup 100 patients in an array of 10000000.

10 clients running concurrently need ~80s each to lookup 100 patients in an array of 10000000.

## HashMap

Use `PatientRegistryUsingHashMap` to see how long it takes to loop up 100 patients in a `HashMap`.

A single client needs 0.0009s (less than 1/10th of a ms) to lookup 100 patients in an array of 10000000.

10 clients running concurrently need 0.01s (~10ms) each to lookup 100 patients in an array of 10000000.

## Conslusion

Using the correct data structure is important.

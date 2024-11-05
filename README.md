Java 22+ FFM demo with Rust
=============================

# Requirements

* JDK 22+
* Rust 1.82+

# Get started

* Build Rust project first: `just build-rust`
* Build Java project
* Run test

# Todo

* Cross compile Rust code for Windows, Linux and MacOS
* Bundle the native libraries with the JAR file
* Load the native libraries from the JAR file

# References

* Java Bindings for Rust: A Comprehensive Guide - https://akilmohideen.github.io/java-rust-bindings-manual/title.html
* JEP 454: Foreign Function & Memory API: https://openjdk.org/jeps/454
* rust-maven-plugin: Build Rust Cargo crates within a Java Maven Project - https://github.com/questdb/rust-maven-plugin
* Foreign Function and Memory API: https://docs.oracle.com/en/java/javase/22/core/foreign-function-and-memory-api.html
* Jextract: a tool which mechanically generates Java bindings from native library
  headers - https://github.com/openjdk/jextract
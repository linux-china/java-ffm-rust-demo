Rust FFI demo
==============

# Writing Your C API

cbindgen has a simple but effective strategy. It walks through your crate looking for:

* `#[no_mangle] pub extern fn` ("functions")
* `#[no_mangle] pub static` ("globals")
* `pub const` ("constants")

and generates a header declaring those items. But to declare those items, it needs to also be able to describe the
layout and ABI of the types that appear in their signatures. So it will also spider through your crate (and optionally
its dependencies) to try to find the definitions of every type used in your public API.

# References

* [cbindgen](https://github.com/mozilla/cbindgen): creates C/C++11 headers for Rust libraries which expose a public C
  API.


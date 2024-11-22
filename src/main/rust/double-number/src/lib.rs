use safer_ffi::prelude::*;

#[allow(non_snake_case)]
#[ffi_export]
fn doubleNumber(n: i32) -> i32 {
    n * 2
}

#[ffi_export]
fn welcome(name: repr_c::String) -> repr_c::String {
    println!("received: {}", name);
    format!("Welcome, {}!", name).into()
}

#[safer_ffi::cfg_headers]
#[test]
fn generate_headers() -> ::std::io::Result<()> {
    ::safer_ffi::headers::builder()
        .to_file("bindings.h")?
        .generate()
}

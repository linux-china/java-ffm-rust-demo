use safer_ffi::prelude::*;

#[allow(non_snake_case)]
#[ffi_export]
fn doubleNumber(n: i32) -> i32 {
    n * 2
}

#[safer_ffi::cfg_headers]
#[test]
fn generate_headers() -> ::std::io::Result<()> {
    ::safer_ffi::headers::builder()
        .to_file("bindings.h")?
        .generate()
}

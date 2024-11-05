#[no_mangle]
#[allow(non_snake_case)]
pub extern "C" fn doubleNumber(n: i32) -> i32 {
    n * 2
}
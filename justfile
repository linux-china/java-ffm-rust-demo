build:
    mvn -DskipTests clean package

build-rust:
    cd src/main/rust/double-number && cargo build --release
    cp target/rust-maven-plugin/double-number/release/libdouble_number.dylib ./

jextract-generate:
    jextract --output src/main/java -t org.rust --header-class-name RustLib -l double_number --include-function doubleNumber src/main/rust/double-number/bindings.h

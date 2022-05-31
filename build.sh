#!/bin/sh

export FLAGS="-Werror -d out/ -cp src/*.java"

function usage() {
    echo "./build.sh [Option]"
    echo "  help: print this help"
    echo "  build: build the project"
    echo "  run: build & run the project"
    exit 1
}

function build() {
    [ ! -d "./out" ] && mkdir out;
    echo "build..."
    javac $FLAGS src/ConsoleJV.java src/pmjv.java src/main.java
    echo "build done"
}

function run() {
    build
    echo -e "------------\nrun...\n------------\n"
    java -cp out/ main
}

if [ $# -ne 1 ]; then
    usage
fi

# check what the first argument is
if [ $1 = "help" ]; then
    usage
elif [ $1 = "build" ]; then
    build
elif [ $1 = "run" ]; then
    run
else
    usage
fi

exit 0
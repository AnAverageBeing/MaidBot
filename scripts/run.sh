#!/bin/sh
echo "------" $(date) "------" >> logs.txt

# Allocate enough memory for the JVM
java \
    -XX:+UseG1GC \
    -XX:+UseStringDeduplication \
    -XX:+UnlockExperimentalVMOptions \
    -XX:ParallelGCThreads=2 \
    -XX:+TieredCompilation \
    -jar MaidBot.jar >> logs.txt 2>&1 &
#!/bin/sh

java \
    -XX:+UseG1GC \
    -XX:+UseStringDeduplication \
    -XX:+UnlockExperimentalVMOptions \
    -XX:+UseZGC \
    -XX:ParallelGCThreads=2 \
    -XX:+TieredCompilation \
    -jar MaidBot.jar >> logs.txt 2>&1 &


screen -S maidbot -d -m sh -c 'sleep 5 && screen -r maidbot'
screen -S maidbot -X stuff $'\030'
screen -S maidbot -X stuff "trap '' INT\n"
screen -S maidbot -X screen -t shell sh -c 'while true; do clear; echo "Bot Running..."; sleep 1; done'

screen -S maidbot -X screen -t watch sh -c 'while true; do if ! pgrep -x java > /dev/null; then sleep 1 && screen -X quit; fi; done'

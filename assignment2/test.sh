#!/bin/bash
#script to test the code using random (valid) input files
MAX_THREADS=1000
while true;
do
	rm input.txt
	NUM_THREADS=$((1 + RANDOM % $MAX_THREADS))
	echo "THREADS: $NUM_THREADS"
	java registrationScheduler.test.RandomInputGenerator input.txt
	java registrationScheduler.driver.Driver input.txt output.txt $NUM_THREADS 0
done

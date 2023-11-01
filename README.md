# The senate bus problem

## Overview
This problem was originally based on the Senate bus at Wellesley College. Riders come to a bus
stop and wait for a bus. When the bus arrives, all the waiting riders invoke boardBus, but anyone who
arrives while the bus is boarding has to wait for the next bus. The capacity of the bus is 50 people; if there
are more than 50 people waiting, some will have to wait for the next bus. When all the waiting riders have
boarded, the bus can invoke depart. If the bus arrives when there are no riders, it should depart
immediately.

Busses and riders will continue to arrive throughout the day. Inter-arrival time
of busses and riders are exponentially distributed with a mean of 20 min and 30 sec, respectively.

## How to run

1) Open a terminal
2) Go to project folder location
3) Move to src folder using ``cd src``
4) Compile the code using ``javac Main.java``
5) Run the program using ``java Main``

Note : The mean time of the exponential distributions are set to the given values 20min and 30 sec 
respectively in the BusScheduler and RiderScheduler classes. The mean times can be reduced to get 
a faster execution.

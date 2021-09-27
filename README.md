<h1 align="center"> Senate-Bus-Problem </h1>


This repo contains the syncronization implementation for the **Senate Bus Problem** taken from **Little book of Semaphores**, page 211.

### Problem:

This problem was originally based on the Senate bus at Wellesley College. Riders come to a bus 
stop and wait for a bus. When the bus arrives, all the waiting riders invoke boardBus, but anyone who 
arrives while the bus is boarding has to wait for the next bus. The capacity of the bus is 50 people; if there 
are more than 50 people waiting, some will have to wait for the next bus. When all the waiting riders have 
boarded, the bus can invoke depart. If the bus arrives when there are no riders, it should depart 
immediately.

**Programming Language Used:**
Java

**Compile Program:**

`javac -d .\classes SenateBusProblemDemo.java`

**Run program:**

`java -cp .\classes SenateBusProblemDemo`

## Output

![image_1](./screenshots/image_1.png)
![image_2](./screenshots/image_2.png)
![image_3](./screenshots/image_3.png)

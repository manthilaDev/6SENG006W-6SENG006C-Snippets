## Monitor

- Shared Resource 
	- Resource Encapsulated inside monitor class 
	- Methods that access the resource should be synchronous 
- Passive Object 
	- Thread will access the passive object

### Reasons for synchronization 
- Race condition 
- If not handled properly shared resource will be left corrupted
- To ensure data safety each of threads accessing a critical section should be mutually accessible 
- Uncoordinated shared resource may cause lost value or Double consumption

## Reentrant Lock Java

[Reference](https://www.geeksforgeeks.org/reentrant-lock-java/)



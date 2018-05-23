# kafka-api

## Tools used:
```
Spring Kafka 1.2
Spring Boot 1.5
Maven 3.5
```

## auto.offset.reset值含义解释
```
earliest 
当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，从头开始消费 
latest 
当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，消费新产生的该分区下的数据 
none 
topic各分区都存在已提交的offset时，从offset后开始消费；只要有一个分区不存在已提交的offset，则抛出异常
```
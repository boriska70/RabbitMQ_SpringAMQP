Sample of working with RabbitMQ using Spring AMQP

- Messages sent explicitly (Sender) but received via configuration only (that forward the message to the listeners)
- Messages sent to the same topic with routing key and goes to only one of the queues
- XML based configuration
- Exchange and both queues are durable (default)
- Everything is auto-declared but NOT auto-deleted (default)
- Messages sent as Persistent (default). If Listener goes down before handleMessage has finished (can be done with sleep
  in this method), the message is stored in the server and resend when the consumer is up again. Then the queue is
  cleaned automatically (takes 1-2 minutes - default timeout?).
- Listener-container acknowledge is set to AUTO (default). Actually the ack only sent when handleMessage method finished



# Rate Limiter: Server

This is the Rate Limiter Server, which is part of my [Rate Limiter Project](https://github.com/tave8/rate-limiter).

Its only job is to simulate real APIs and services exposed over the network.

The proper name would be "services / APIs simulator" but "server" was shorter, so I stuck with that.

So do not mistake this server, which is a "services simulator" with the actual Rate Limiter server.

How it works? Very simple. Each endpoint exposes a service.

## Services 

These are the services exposed by this server.

Each service will send you a 429 status code if you surpass the max request limit, which is the whole point of this project.

However because a rate limiter should sit between the actual client (you) and the API server (third-party, which we're simulating here) precisely to rate limit, you should not receive any 429 status code. If you do, it means either the Rate Limiter needs fixing, or we've chosen to skip the Rate Limiter and made a request directly to the API service.


| Endpoint   | Service   |
|------------|-----------|
| /email-api | Email API |
| /ai-api    | AI API    |


### Email API

Request (json)

```
{
    "recipient": "mary@mail.com",
    "subject": "You are invited to work meeting",
    "body": "Just writing you something"
}
```

Response (json)

```
{
    "id": "xyz"
}
```
# GammaRedisClient

## What?
Just write a redis client for fun. For those who seriously looks for redis client, I would recommend jedis  https://github.com/xetorthio/jedis

## Goal
1. Integrate with more redis commands.
2. Design a credential and user system. There should a admin and normal user. Admin user has the right to maintain the whole data. It has the right to evict or remove user data whenever there is an emergency. Normal user is assigned with a limited memory and the request will be throttled if the user wants to save more data. Also excessive requests must be throttled to protect the redis server.
3. Re-design the client. Need some thoughts on how to design the redis client. Do we need a threadpool if there are many requests? Do we need a async client?

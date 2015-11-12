
## 使用说明

> 由于使用的是内网地址，在提供外网服务的时候，需要将内网地址改成外网地址。

```
UPDATE frame_text_samples SET frame_url=CONCAT("http://ip:port",SUBSTRING(frame_url,26));
```
**其中，ip和port是对应的外网地址和端口**


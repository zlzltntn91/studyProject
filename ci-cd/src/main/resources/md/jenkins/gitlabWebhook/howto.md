# Gitlab Webhook

## AccessToken
1. Profile -> Setting -> AccessToken
2. Name 입력
3. Expires at (만료기간) 입력
4. Create personal access token 클릭

## Set Jenkins
1. Plugin Download (Gitlab plugin, Gitlab webhook plugin)
2. Build trigger -> Build when a change is pushed to GitLab.
3. 고급에서 Secret token Generate
4. URL 복사

## Set Webhook
1. Repository -> Setting -> Webhooks
2. 
3.




`gitlab Import url is blocked: "Requests to the local network are not allowed"`

Admin -> Settings -> Network -> Outbound Requests ->
Allow requests to the local network from hooks and services

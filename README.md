# Tesi Salvatore Iannicella

Il codice si trova: swagger-spring/src/main/java/io/swagger/api/Flora/FloraApiController. Per poter utilizzare il web service bisogna utilizzare intellij oppure installare dal marketplace di eclipse lo "Spring Tools" e scaricare le librerie HTMLUnit. Una volta aver effettuato il run bisogna utilizzare ngrok. Ngrok è un reverse proxy server cross-platform con cui è possibile esporre un server locale, collocato dietro NAT, e firewall alla rete Internet tramite secure tunnel. Gli endpoint da utilizzare sono: Flora/submit e Flora/values (esclusivamente per il form dedicato ala giunta comunale). Inserire questi due endpoint subito dopo la fine dell'url generato con ngrok.


## Esempio ngrok  
ngrok genera l'url "http://10e4-2001-b07-a56-c2cf-a5cf-9902-b7fc-5216.ngrok.io", per collegare i conversational form al web service bisognerà scrivere http://10e4-2001-b07-a56-c2cf-a5cf-9902-b7fc-5216.ngrok.io/Flora/submit" oppure "http://10e4-2001-b07-a56-c2cf-a5cf-9902-b7fc-5216.ngrok.io/Flora/values" per i valori ammissibili del form della giunta comunale.
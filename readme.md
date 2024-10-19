# A Dumb Slow App for Testing Kubernetes Probe 

## Goal
To simulate a slow response when doing `liveness` or `readiness` probe on a Kubernetes environment.

## Configurations
Use below `ENV` variables to define response time (in seconds)
```yaml
      env:
        - name: HEALTHY_PROBE_SECONDS
          value: 20  #configure this
        - name: READY_PROBE_SECONDS
          value: 5  #configure this
```

With below probe configuration, change `timeoutSeconds` to simulate auto-heal 
```yaml
    livenessProbe:
      httpGet:
        path: /healthy
        port: 8080
      initialDelaySeconds: 5
      periodSeconds: 5
      timeoutSeconds: 5 #configure this
    readinessProbe:
      httpGet:
        path: /ready
        port: 8080
      initialDelaySeconds: 5
      periodSeconds: 5
      timeoutSeconds: 5 #configure this
```
# CO-WIN Vaccine Tracker

This is a springboot application for retreiving the list of vaccination centres for the provided region and on the basis of age group.

## Configurations

**cowin.district.id** : Enter the District Id of your area.


**age** : Enter the age group for which you want to find slots.

The application polls information every 5 hours, which will be made configurable in the nex iteration.

## Get Meta-data

Get the information of the **district.id** using these steps:

Enter the URL in browser
```
https://cdn-api.co-vin.in/api/v2/admin/location/states
```

Search for your stateId and enter it in the below placeholder and enter the URL in browser

```
https://cdn-api.co-vin.in/api/v2/admin/location/districts/<state_id>
```

Choose your District Id and provide in the **application.yaml**

## Contribution

Feel free to add more features to the application and help the community. Raise a PR against the master. 
Branch name convention: ```feature/added-<tool name>```

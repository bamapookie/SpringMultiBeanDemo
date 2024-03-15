# Spring Multi-Bean Demo

## Purpose

This project demonstrates how to instantiate multiple versions of a generic service dynamically through application
properties.

The properties are read in from application.properties and stored in the `beans` parameter of the
`ApplicationsPropertyMap` class.  The beans map is then used to instantiate the dynamic beans in the
`MultiBeanConfiguration` class.  The beans are configured to match by their generic types, so that the correct bean is
injected into the `Controller` class.  Additional configuration can be added to the map to allow for type-specific
configuration of the generic service.  Unfortunately, the beans are dynamically created at runtime, so your IDE will be
of little help if you leave out a generic type from your configuration, or leave an unused generic type in.


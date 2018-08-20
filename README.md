Apache Beam / Google Dataflow pipeline for streaming messages from Pubsub queue to MarkLogic database

# Overview

This is an Apache Beam streaming pipeline for content ingestion into a MarkLogic database. The pipeline consists
of three steps:

1. Read messages from a Pubsub event queue into a PCollection.

1. Envelope the JSON payload and add provenance information.

1. Upload the transformed JSON to a MarkLogic database.

The cloud deployment of this pipeline runs an instance of [`StreamToMarkLogic`](https://github.com/ezbc/drug-portal-dataflow/blob/master/src/main/java/com/drugportal/dataflow/load/StreamToMarkLogic.java)

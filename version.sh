#!/bin/sh
echo $(git rev-parse --abbrev-ref HEAD)-$(git describe --abbrev=0 --tags)


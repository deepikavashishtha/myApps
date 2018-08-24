#!/bin/bash
# wait-for-mysql.sh

set -e

host="$1"
shift
cmd="$@"

until PGPASSWORD=password mysql -h "localhost" -U "root" -c '\q'; do
  >&2 echo "mysql is unavailable - sleeping"
  sleep 1
done

>&2 echo "mysql is up - executing command"
exec $cmd:q

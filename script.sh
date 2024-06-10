for i in {1..15}
do
  # Send a curl request to google.com
  curl --location --request POST "http://localhost:8080/produce?message=somemessage-$i"
done

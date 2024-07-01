import json

file_path = 'C:\Users\Bruker\Code\Advent of Code\Day 1\Day1\src\main\resources\strings.txt'

# Read the strings from the file
with open('strings.txt', 'r') as file:
    lines = file.read().splitlines()

# Create a dictionary with the list of strings
data = {"list": lines}

# Convert the dictionary to JSON format
json_data = json.dumps(data, indent=2)

# Write the JSON data to a file
with open('strings.json', 'w') as json_file:
    json_file.write(json_data)

print("JSON file generated successfully.")

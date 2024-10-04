import requests

base_url = "http://localhost:8080/api"  # Replace with your API base URL

endpoints = [
    "/movies",
    "/actors",
    "/directors",
    "/genres"
]


# Test PUT requests
put_payloads = {
    "/movies/1": {
        "title": "Updated Movie",
        "description": "An updated movie description",
        "releaseYear": 2024,
        "actorIds": [1, 3],
        "directorIds": [2],
        "genreIds": [2, 3]
    },
    "/actors/1": {
        "name": "Updated Actor",
        "bio": "An updated actor bio"
    },
    "/directors/1": {
        "name": "Updated Director",
        "bio": "An updated director bio"
    },
    "/genres/1": {
        "name": "Updated Genre"
    }
}

for endpoint, payload in put_payloads.items():
    response = requests.put(base_url + endpoint, json=payload)
    print(f"PUT {endpoint}: {response.status_code}")
    if response.status_code == 400:
        print(f"Error details: {response.json()}")


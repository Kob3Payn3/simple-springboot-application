document.addEventListener("DOMContentLoaded", function () {
    const apiUrl = "/api/v1/player/getPlayers";
    const tableBody = document.getElementById("tableBody");

    console.log("Fetching data from:", apiUrl); // Log URL

    fetch(apiUrl)
        .then(response => {
            console.log("Response status:", response.status); // Check status
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            console.log("Fetched data:", data); // Log JSON response
            if (!Array.isArray(data)) {
                console.error("Error: API did not return an array");
                return;
            }

            // Check if data is being looped
            data.forEach(player => {
                console.log("Player data:", player); // Log each player data
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${player.id}</td>
                    <td>${player.name}</td>
                    <td>${player.age}</td>
                    <td>${player.position}</td>
                    <td>${player.gamesPlayed}</td>
                    <td>${player.plateAppearances}</td>
                    <td>${player.runs}</td>
                    <td>${player.hits}</td>
                    <td>${player.doubles}</td>
                    <td>${player.triples}</td>
                    <td>${player.homeruns}</td>
                    <td>${player.rbi}</td>
                    <td>${player.sb}</td>
                    <td>${player.strikeouts}</td>
                    <td>${player.battingAverage}</td>
                    <td>${player.obp}</td>
                    <td>${player.slg}</td>
                    <td>${player.ops}</td>
                `;
                tableBody.appendChild(row);
            });

            // Log table body to check if the rows are appended
            console.log("Updated table body:", tableBody.innerHTML);
        })
        .catch(error => {
            console.error("Error fetching players:", error);
        });
});


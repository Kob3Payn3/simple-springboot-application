document.addEventListener("DOMContentLoaded", function () {
    const apiUrl = "/api/v1/player/getPlayers";
    const tableBody = document.getElementById("tableBody");

    console.log("Fetching data from:", apiUrl);

    fetch(apiUrl)
        .then(response => {
            console.log("Response status:", response.status);
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            console.log("Fetched data:", data);
            if (!Array.isArray(data)) {
                console.error("Error: API did not return an array");
                return;
            }

            data.forEach(player => {
                console.log("Player data:", player);
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

            console.log("Updated table body:", tableBody.innerHTML);
        })
        .catch(error => {
            console.error("Error fetching players:", error);
        });
});


let currentSortBy = "id";
let currentOrder = "asc";

function fetchPlayers(sortBy = "id", order = "asc") {
    currentSortBy = sortBy;
    currentOrder = order;

    fetch(`/api/v1/player/getPlayers?sortBy=${sortBy}&order=${order}`)
        .then(response => response.json())
        .then(players => {
            let tableBody = document.getElementById("tableBody");
            tableBody.innerHTML = "";

            players.forEach(player => {
                let row = `<tr>
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
                </tr>`;
                tableBody.innerHTML += row;
            });
        });
}

function toggleSort(column) {
            let order = (currentSortBy === column && currentOrder === "asc") ? "desc" : "asc";
            fetchPlayers(column, order);
        }

function searchFunction() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("playerSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("playerTable");
    tr = table.getElementsByTagName("tr");

    let searchableColumns = [1, 2, 3] //Name, age, and position

    for (i = 1; i < tr.length; i++) { //make is start at 1 so it skips the table header
    let rowVisible = false;
        td = tr[i].getElementsByTagName("td");

        for (let j of searchableColumns) {
            if (td[j]) {
                txtValue = td[j].textContent || td[j].innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    rowVisible = true;
                    break;
                }
            }
        }
        tr[i].style.display = rowVisible ? "" : "none";
    }
}

function openSideNav() {
    document.getElementById("create-update-side-nav").style.width = "800px";
    document.getElementById("create-update-side-nav").style.transform = "translateX(0)";
}

function closeSideNav() {
    document.getElementById("create-update-side-nav").style.width = "0px";
    document.getElementById("create-update-side-nav").style.transform = "translateX(-100%)";
}


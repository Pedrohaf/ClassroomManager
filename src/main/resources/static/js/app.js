const API_URL = "/classrooms";

const form = document.getElementById("classroomForm");
const tableBody = document.querySelector("#tableClassrooms tbody");
const cancelBtn = document.getElementById("cancelBtn");

async function listarSalas() {
  const res = await fetch(API_URL);
  const data = await res.json();
  renderTable(data);
}

function renderTable(classrooms) {
  tableBody.innerHTML = "";
  classrooms.forEach(c => {
    const row = document.createElement("tr");
    row.innerHTML = `
      <td>${c.id}</td>
      <td>${c.name}</td>
      <td>${c.capacity}</td>
      <td>${c.location}</td>
      <td>
        <button class="btn btn-sm btn-warning me-2" onclick="editar(${c.id})">Editar</button>
        <button class="btn btn-sm btn-danger" onclick="excluir(${c.id})">Excluir</button>
      </td>
    `;
    tableBody.appendChild(row);
  });
}

form.addEventListener("submit", async e => {
  e.preventDefault();
  const id = document.getElementById("id").value;
  const name = document.getElementById("name").value;
  const capacity = document.getElementById("capacity").value;
  const location = document.getElementById("location").value;

  const classroom = { name, capacity, location };
  const method = id ? "PUT" : "POST";
  const url = id ? `${API_URL}/${id}` : API_URL;

  await fetch(url, {
    method,
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(classroom)
  });

  form.reset();
  cancelBtn.hidden = true;
  listarSalas();
});

async function editar(id) {
  const res = await fetch(`${API_URL}/${id}`);
  const c = await res.json();
  document.getElementById("id").value = c.id;
  document.getElementById("name").value = c.name;
  document.getElementById("capacity").value = c.capacity;
  document.getElementById("location").value = c.location;
  cancelBtn.hidden = false;
}

async function excluir(id) {
  if (confirm("Tem certeza que deseja excluir esta sala?")) {
    await fetch(`${API_URL}/${id}`, { method: "DELETE" });
    listarSalas();
  }
}

cancelBtn.addEventListener("click", () => {
  form.reset();
  document.getElementById("id").value = "";
  cancelBtn.hidden = true;
});

listarSalas();

function logout() {
    localStorage.removeItem('username'); // Entferne den Benutzernamen aus dem localStorage
    window.location.href = 'login.html'; // Zur Anmeldeseite leiten
}

// Funktion zum Abrufen und Rendern der Kurse
async function renderCourses() {
    const courseList = document.getElementById("course-list");

    try {
        const response = await fetch('http://localhost:8080/api/courses'); // API-URL
        const courses = await response.json();

        courses.forEach(course => {
            const li = document.createElement("li");
            li.textContent = course.title;
            courseList.appendChild(li);
        });
    } catch (error) {
        console.error('Fehler beim Abrufen der Kurse:', error);
    }
}

// Initialisierung der Anzeige
renderCourses();

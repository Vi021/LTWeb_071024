
// fileUpload.js
function chooseFile(fileInput) {
    if (fileInput.files && fileInput.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            // Update the src attribute of the image element with ID 'catImg'
            document.getElementById('catImg').src = e.target.result;
        }
        reader.readAsDataURL(fileInput.files[0]);
    }
}

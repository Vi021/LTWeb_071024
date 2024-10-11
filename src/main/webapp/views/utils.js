

function showImage(fileInput) {
    if (fileInput.files && fileInput.files[0]) {
        var reader = new FileReader();

        // Once the file is read, this event is fired
        reader.onload = function(e) {
            // Set the source of the image to the result of the FileReader
            document.getElementById('catImg').src = e.target.result;
        };

        // Read the file as a DataURL (which is a base64 encoded string representing the image)
        reader.readAsDataURL(fileInput.files[0]);
    }
}

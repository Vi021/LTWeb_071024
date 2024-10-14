
<script src="../jquery.min.js" type="text/javascript"></script>
<script>
    function showImage(fileInput) {
        if (fileInput.files && fileInput.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                //catImg in category-add.jsp, category-edit.jsp
                $('#showImg').attr('src', e.target.result);
            }
            reader.readAsDataURL(fileInput.files[0]);
        }
    }
</script>
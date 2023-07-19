<!DOCTYPE html>
<html>
<head>
    <title>Dynamic Select Options</title>
</head>
<body>
    <h1>Dynamic Select Options Example</h1>

    <select id="select1" onchange="updateSelect2()">
        <option value="option1">Option 1</option>
        <option value="option2">Option 2</option>
        <option value="option3">Option 3</option>
    </select>

    <select id="select2">
        <!-- The options for this select will be populated dynamically -->
    </select>

    <script>
        function updateSelect2() {
            var select1Value = document.getElementById('select1').value;
            var select2 = document.getElementById('select2');

            // Clear previous options
            select2.innerHTML = '';

            // Add new options based on the selected value of select1
            if (select1Value === 'option1') {
                select2.add(new Option('Suboption 1-1', 'suboption1-1'));
                select2.add(new Option('Suboption 1-2', 'suboption1-2'));
            } else if (select1Value === 'option2') {
                select2.add(new Option('Suboption 2-1', 'suboption2-1'));
                select2.add(new Option('Suboption 2-2', 'suboption2-2'));
            } else if (select1Value === 'option3') {
                select2.add(new Option('Suboption 3-1', 'suboption3-1'));
                select2.add(new Option('Suboption 3-2', 'suboption3-2'));
            }
        }
    </script>
</body>
</html>
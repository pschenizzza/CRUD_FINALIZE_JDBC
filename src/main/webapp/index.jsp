<html>
<body>

<div>
    <h1>Great database for users who can register</h1>
</div>


<section class="fields">
    <form action="/adduser" method="POST">
        Username: <br><input type="text" name="username" required PLACEHOLDER="your name"> <br>
        Password: <br><input type="password" name="password" required PLACEHOLDER="your password"> <br>
        Gender:
        <p>
            <select name="gender">
                <option disabled>Select gender</option>
                <option value="male">male</option>
                <option value="female">female</option>
            </select>
        </p>


        <input type="submit" value="Register"><br>
    </form>
</section>
<H1></H1>

</div>
</body>
</html>

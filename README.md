<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    /* Add some styles to improve the look of the page */
    body {
      font-family: Arial, sans-serif;
      margin: 0;
    }
    .container {
      max-width: 800px;
      margin: 0 auto;
      padding: 40px 20px;
      box-sizing: border-box;
    }
    .logo {
      display: block;
      margin: 0 auto;
      width: 200px;
      height: 200px;
    }
    h1 {
      font-size: 48px;
      text-align: center;
      margin: 0;
      margin-top: 40px;
    }
    h2 {
      font-size: 36px;
      margin: 40px 0 20px;
    }
    p {
      font-size: 24px;
      line-height: 1.5;
      margin: 0;
    }
    ul, ol {
      list-style: none;
      margin: 0;
      padding: 0;
    }
    li {
      font-size: 24px;
      line-height: 1.5;
      margin: 10px 0;
    }
    code {
      font-family: Consolas, monospace;
      background-color: #f5f5f5;
      padding: 2px 5px;
      border-radius: 5px;
    }
    a {
      color: #333;
      text-decoration: none;
    }
    a:hover {
      text-decoration: underline;
    }
    button {
      font-size: 24px;
      color: #fff;
      background-color: #333;
      border: none;
      border-radius: 5px;
      padding: 10px 20px;
      cursor: pointer;
      transition: background-color 0.3s;
    }
    button:hover {
      background-color: #666;
    }
  </style>
</head>
<body>
  <div class="container">
    <img src="https://iili.io/HGcjFi7.jpg" alt="MaidBOT Logo" class="logo">
    <h1>MaidBOT</h1>
    <p>
      MaidBOT is a personal Discord bot project written in Java using the JDA library. It provides various commands that can be useful for managing your Discord server.
    </p>
    <h2>🤖 Commands</h2>
    <ul>
      <li>🟢 <code>.ping</code> - Returns the latency of the bot.</li>
      <li>❓ <code>.help</code> - Provides information about the available commands.</li>
      <li>🌐 <code>.rstuff</code> - Retrieves random anime images based on specified tags.</li>
      <li>🔄 <code>.update</code> - Updates and re-runs the bot by downloading the latest version from this GitHub repository.</li>
      <li>⏹️ <code>.stop</code> - Stops the bot.</li>
    </ul>
  <h2>🛠️ How to Use</h2>
  
  <ol>
    <li>Create a directory to hold bot files. </li>
    <li>Create a file named <code>token.txt</code> and put your bot token into it. </li>
    <li>Copy the <code>run.sh</code> script into the directory. </li>
    <li>Copy <code>MaidBot.jar</code> into the directory. </li>
    <li>Run the <code>run.sh</code> script. </li>
  </ol>
  
  <h2>💻 Improving MaidBOT</h2>
  
  <p>
    Feel free to contribute to MaidBOT by submitting pull requests or opening issues on this GitHub repository. Your feedback is greatly appreciated.
  </p>
  
  <h2>📜 License</h2>
  
  <p>
    MaidBOT is licensed under the <a href="https://opensource.org/licenses/MIT" target="_new">MIT License</a>. See the LICENSE file for more information.
  </p>  
</body>
</html>
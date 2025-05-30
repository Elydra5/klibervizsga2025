const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const berlesekRouter = require('./router/api');


const app = express()
app.use(cors({origin: 'http://localhost:4200'}))
app.use(bodyParser.json())
const port = 3000

app.get('/', (req, res) => {
  res.send('Fut')
})

app.use('/api', berlesekRouter)

app.listen(port, () => {
  console.log(`Fut itt: http://localhost:${port}`)
})
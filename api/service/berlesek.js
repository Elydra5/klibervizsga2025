const db = require("./db")

async function getBerlesek(){
    const sql = "SELECT * FROM berlesek"
    const params = []
    const result = await db.query(sql, params)
    return result
}

async function getBerlesekById(id){
    const sql = "SELECT * FROM berlesek WHERE id = ?"
    const params = [id]
    const result = await db.query(sql, params)
    return result
}

async function addBerles(chefId, startDate, endDate) {
  const sql = "INSERT INTO berlesek (chefId, startDate, endDate) VALUES (?, ?, ?)"
  const params = [chefId, startDate.format('YYYY-MM-DD'), endDate.format('YYYY-MM-DD')]
  const result = await db.query(sql, params)
  return { id: result.insertId, chefId, startDate, endDate }
}

async function deleteBerles(id){
    const sql = "DELETE FROM berlesek WHERE id = ?"
    const params = [id]
    const result = await db.query(sql, params)
    return result
}

async function checkOverlap(chefId, startDate, endDate) {
  const sql = `
    SELECT * FROM berlesek WHERE chefId = ? AND ((startDate < ? AND endDate > ?) OR(startDate < ? AND endDate > ?))`
  const params = [
    chefId,
    endDate.format('YYYY-MM-DD'),
    startDate.format('YYYY-MM-DD'),
    startDate.format('YYYY-MM-DD'),
    endDate.format('YYYY-MM-DD')]
  const result = await db.query(sql, params)
  return result
}

module.exports = {
    getBerlesek,
    getBerlesekById,
    addBerles,
    deleteBerles,
    checkOverlap
}
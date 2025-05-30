const express = require('express')
const router = express.Router()
const berlesek = require('../service/berlesek')
const moment = require('moment');


router.get('/berlesek', async (req, res) => {
    try {
      const result = await berlesek.getBerlesek()
      res.json(result)
    } catch (err) {
      console.error(err)
      res.status(500).send('Hiba történt a bérlések lekérésekor')
    }
})

router.get('/berlesek/:id', async (req, res) => {
    const id = req.params.id
    berlesek.getBerlesekById(id).then(result => {
            if (result.length > 0) {
                res.json(result[0])
            } else {
                res.status(404).send('Berles nem található')
            }
        }).catch(err => {
            console.error(err)
            res.status(400).send('Hiba történt a bérlés lekérésekor')
        })
})

router.post('/berlesek', async (req, res) => {
    const { chefId, startDate, endDate } = req.body

        const today = moment().add(1, 'days')
        const start = moment(startDate)
        const end = moment(endDate)
    if (start.isBefore(today, 'day')) {
        return res.status(400).send('A bérlés kezdőnapja nem lehet korábbi, mint a holnapi nap.')
    }

    if (end.diff(start, 'days') < 3) {
        return res.status(400).send('A bérlés időtartama legalább 3 nap kell, hogy legyen.')
    }

    if (end.diff(start, 'days') > 14) {
        return res.status(400).send('A bérlés időtartama legfeljebb 14 nap lehet.')
    }

    const overlappingBookings = await berlesek.checkOverlap(chefId, start, end)
    if (overlappingBookings.length > 0) {
        return res.status(400).send('Ugyanaz a séf már lefoglalt ezen az időszakon belül.')
    }
    try {
        const newBooking = await berlesek.addBerles(chefId, start, end)
        res.status(201).json(newBooking)
    } catch (err) {
        console.error(err)
        res.status(500).send('Hiba történt a bérlés rögzítésekor.')
    }
})

router.delete('/berlesek/:id', async (req, res) => {
    const { id } = req.params
    try {
        const result = await berlesek.deleteBerles(id)
        if (result) {
            res.status(200).send('Bérlés törölve.')
        } else {
            res.status(404).send('Bérlés nem található.')
        }
        } catch (err) {
            console.error(err)
            res.status(500).send('Hiba történt a bérlés törlésekor.')
        }
})

module.exports = router
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ExemploWebApi.Models;

namespace ExemploWebApi.Controllers
{
    public class HeroisController : ApiController
    {
        private static List<Heroi> Herois = new List<Heroi>();
        public static int QuantidadeHerois = 0;
        public object objetoLock = new object();

        public List<Heroi> Get(int? id = null)
        {
            if (id == null)
            {
                return Herois;
            }
            return Herois.Where(x => x.Id.Equals(id)).ToList();
        }
        public IHttpActionResult Post(Heroi heroi)
        {
            if (heroi.Id == 0)
            {
                lock(objetoLock)
                {
                    QuantidadeHerois++;
                    heroi.Id = QuantidadeHerois;
                    Herois.Add(heroi);
                    return Ok();
                }

        }
            else
            {
                return BadRequest();
    }
}
    }
}

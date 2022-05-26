package com.example.huapaya_luis_examenfinalzip

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.huapaya_luis_examenfinalzip.databinding.ElementoBinding
import com.example.huapaya_luis_examenfinalzip.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        setHasOptionsMenu(true) // permite la funcionalidad de las opciones del menu
        _binding = FragmentFirstBinding.inflate(inflater, container, false)


        with(binding.recyclerView1) {
            val listAlbum: MutableList<Album> = ArrayList()
            binding.btnRock.setOnClickListener {
                binding.recyclerView1.visibility = View.VISIBLE
                adapter = Custom1Adapter(cargarDatosRock())
                layoutManager = LinearLayoutManager(requireContext())
//                binding.cbRock.isChecked = true
//                binding.cbBlues.isChecked = false
//                binding.cbJazz.isChecked = false
            }
            binding.btnBlues.setOnClickListener {
                binding.recyclerView1.visibility = View.VISIBLE
                adapter = Custom1Adapter(cargarDatosBlues())
                layoutManager = LinearLayoutManager(requireContext());
//                binding.cbRock.isChecked = false
//                binding.cbBlues.isChecked = true
//                binding.cbJazz.isChecked = false
            }
            binding.btnJazz.setOnClickListener {
                binding.recyclerView1.visibility = View.VISIBLE
                adapter = Custom1Adapter(cargarDatosJazz())
                layoutManager = LinearLayoutManager(requireContext());
//                binding.cbRock.isChecked = false
//                binding.cbBlues.isChecked = false
//                binding.cbJazz.isChecked = true
            }


            binding.cbRock.setOnCheckedChangeListener { buttonView, isChecked ->
                listAlbum.addAll(cargarDatosRock());
                binding.recyclerView1.visibility = View.VISIBLE
                adapter = Custom1Adapter(listAlbum)
                layoutManager = LinearLayoutManager(requireContext())
            }

            binding.cbBlues.setOnCheckedChangeListener { buttonView, isChecked ->
                listAlbum.addAll(cargarDatosBlues());
                binding.recyclerView1.visibility = View.VISIBLE
                adapter = Custom1Adapter(listAlbum)
                layoutManager = LinearLayoutManager(requireContext());
            }
            binding.cbJazz.setOnCheckedChangeListener { buttonView, isChecked ->
                listAlbum.addAll(cargarDatosJazz());
                binding.recyclerView1.visibility = View.VISIBLE
                adapter = Custom1Adapter(listAlbum)
                layoutManager = LinearLayoutManager(requireContext());
            }
        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.itemSimple -> {
                binding.btnRock.visibility = View.VISIBLE
                binding.btnBlues.visibility = View.VISIBLE
                binding.btnJazz.visibility = View.VISIBLE
                binding.cbRock.visibility = View.GONE
                binding.cbBlues.visibility = View.GONE
                binding.cbJazz.visibility = View.GONE
                true
            }
            R.id.itemCompuesto -> {
                binding.cbRock.visibility = View.VISIBLE
                binding.cbBlues.visibility = View.VISIBLE
                binding.cbJazz.visibility = View.VISIBLE
                binding.btnRock.visibility = View.GONE
                binding.btnBlues.visibility = View.GONE
                binding.btnJazz.visibility = View.GONE
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    class Custom1Adapter(private val listAlbum: MutableList<Album>) :
    /** El constructor recibirá los datos que queramos que el adaptador vuelque a la lista  */
        RecyclerView.Adapter<Custom1Adapter.ViewHolder>() {

        /** Clase que describe la vista de cada elemento de la lista y su posición en esta. */
        class ViewHolder(binding: ElementoBinding) : RecyclerView.ViewHolder(binding.root) {
            val mView = binding.root
            val title = binding.tvTitle
            val author = binding.tvAuthor
            val image = binding.imageMusic
            val info = binding.imageInfo
            val borrar = binding.imageRemove

            init {
                mView.setOnClickListener {
                    Toast.makeText(
                        binding.root.context,
                        "Has selecionado: " + title.text,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            ElementoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

        /** Asigno a cada elemento declarado anteriormente el valor que va a tomar de acuerdo a lo que
         * contiene la lista cargada anteriormente */
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.title.text = listAlbum[position].title
            holder.author.text = listAlbum[position].author
            holder.image.setImageResource(listAlbum[position].imageId)

            with(holder) {
                if (position % 2 == 0) { // Si la posición de la fila es par
                    mView.setBackgroundColor(Color.CYAN)
                    title.setTextColor(Color.BLACK)
                    author.setTextColor(Color.BLACK)
                    info.setBackgroundColor(Color.parseColor("#0E3166"))
                    borrar.setBackgroundColor(Color.parseColor("#0E3166"))
                } else { // Si la posición es BLACK
                    mView.setBackgroundColor(Color.TRANSPARENT)
                    title.setTextColor(Color.CYAN)
                    author.setTextColor(Color.CYAN)
                    info.setBackgroundColor(Color.CYAN)
                    borrar.setBackgroundColor(Color.CYAN)
                }
            }
        }

        override fun getItemCount() = listAlbum.size
    }

    private fun cargarDatosRock(): MutableList<Album> {
        val listRock: MutableList<Album> = ArrayList()
        listRock.add(
            Album(
                "Abbey Road", "The Beatles", R.drawable.abbeyroad,
                resources.getString(R.string.abbeyroad)
            )
        )
        listRock.add(
            Album(
                "Exile on Main Street", "The Rolling Stones", R.drawable.exileonmainst,
                resources.getString(R.string.exilesonmainstreet)
            )
        )
        listRock.add(
            Album(
                "The Velvet Underground",
                "The Velvet Underground and Nico",
                R.drawable.velvetunderground,
                resources.getString(R.string.velvetunderground)
            )
        )
        listRock.add(
            Album(
                "Are You Experienced", "Jimi Hendrix", R.drawable.areyouexperienced,
                resources.getString(R.string.areyouexperienced)
            )
        )
        listRock.add(
            Album(
                "Back in Black", "AC/DC", R.drawable.backinblack,
                resources.getString(R.string.backinblack)
            )
        )
        listRock.add(
            Album(
                "Appetite for Destruction", "Guns N’ Roses", R.drawable.appetitefordestruction,
                resources.getString(R.string.appetitefordestruction)
            )
        )
        listRock.add(
            Album(
                "Led Zeppelin IV", "Led Zeppelin", R.drawable.ledzeppeliniv,
                resources.getString(R.string.ledzeppeliniv)
            )
        )
        return listRock
    }

    private fun cargarDatosBlues(): MutableList<Album> {
        val listBlues: MutableList<Album> = ArrayList()
        listBlues.add(
            Album(
                "Lady Soul", "Aretha Franklin", R.drawable.ladysoul,
                resources.getString(R.string.ladysoul)
            )
        )
        listBlues.add(
            Album(
                "I Never Loved a Man the Way I Love You", "Aretha Franklin", R.drawable.neverloved,
                resources.getString(R.string.ineverloveda)
            )
        )
        listBlues.add(
            Album(
                "What's Going On", "Marvin Gaye", R.drawable.whatsgoingon,
                resources.getString(R.string.whatsgoingon)
            )
        )
        return listBlues
    }

    private fun cargarDatosJazz(): MutableList<Album> {
        val listJazz: MutableList<Album> = ArrayList()
        listJazz.add(
            Album(
                "Kind of Blue", "Miles Davis", R.drawable.kindofblue,
                resources.getString(R.string.kindofblue)
            )
        )
        listJazz.add(
            Album(
                "Bitches Brew", "Miles Davis", R.drawable.bitchesbrew,
                resources.getString(R.string.bitchesbrew)
            )
        )
        listJazz.add(
            Album(
                "A Love Supreme", "John Coltrane", R.drawable.alovesupreme,
                resources.getString(R.string.alovesupreme)
            )
        )

        return listJazz
    }
}